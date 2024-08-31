package com.onlycgl.cgl.createMocktest.service;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;
import com.onlycgl.cgl.createMocktest.entity.QuestionTranslation;
import com.onlycgl.cgl.createMocktest.repository.MockTestRepository;
import com.onlycgl.cgl.createMocktest.repository.QuestionRepository;
import com.onlycgl.cgl.createMocktest.repository.QuestionTranslationRepository;
import java.io.InputStream;
import java.util.Date;
@Service
public class ExcelServiceTest {
    @Autowired
    private MockTestRepository mockTestRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionTranslationRepository questionTranslationRepository;
    public int saveDataFromExcel(MultipartFile file) {
        int savedCount = 0;
        try {
            InputStream inputStream = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            boolean isFirstTime = true;
            MockTest mockTest = new MockTest();
            for (Row row : sheet) {
                if (row.getRowNum() == 0) {
                    continue; // Skip the header row
                }

                if (isFirstTime) {
                    // Assume columns are in a specific order based on your Excel sheet
                    mockTest.setTitle(row.getCell(0).getStringCellValue());
                    mockTest.setDuration((int) row.getCell(1).getNumericCellValue());
                    mockTest.setTotalQuestions((int) row.getCell(2).getNumericCellValue());
                    mockTest.setCreatedAt(new Date());

                    mockTestRepository.save(mockTest);
                    isFirstTime = false;
                }

                Question question = new Question();
                question.setMockTest(mockTest);
                question.setDifficultyLevel(row.getCell(3).getStringCellValue());
                question.setSubject(row.getCell(4).getStringCellValue());
                question.setTagOrTopic(row.getCell(5).getStringCellValue());
                question.setMarks((int) row.getCell(6).getNumericCellValue());
                question.setNegativeMarks((int) row.getCell(7).getNumericCellValue()); // Assuming negative marks are in
                                                                                       // cell 7

                questionRepository.save(question);
                int languageColumn = 8; // Start reading language code from the correct column

                while (languageColumn < row.getLastCellNum()) {
                    String languageCode = row.getCell(languageColumn).getStringCellValue(); // Read language code
                    QuestionTranslation questionTranslation = new QuestionTranslation();
                    questionTranslation.setQuestion(question);
                    questionTranslation.setLanguageCode(languageCode);
                    questionTranslation.setQuestionText(row.getCell(languageColumn + 1).getStringCellValue());
                    questionTranslation.setOptionA(row.getCell(languageColumn + 2).getStringCellValue());
                    questionTranslation.setOptionB(row.getCell(languageColumn + 3).getStringCellValue());
                    questionTranslation.setOptionC(row.getCell(languageColumn + 4).getStringCellValue());
                    questionTranslation.setOptionD(row.getCell(languageColumn + 5).getStringCellValue());

                    // Set the new fields
                    questionTranslation.setCorrectOption(row.getCell(languageColumn + 6).getStringCellValue());
                    questionTranslation.setExplanation(row.getCell(languageColumn + 7).getStringCellValue());
                    questionTranslation.setHint(row.getCell(languageColumn + 8).getStringCellValue());

                    questionTranslationRepository.save(questionTranslation);
                    savedCount++;

                    languageColumn += 9; // Move to the next language set (code + 8 columns for translation + 1 for
                                         // correct option)
                }

            }

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedCount;
    }
}
