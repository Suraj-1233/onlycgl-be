package com.onlycgl.cgl.userMocktest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlycgl.cgl.createMocktest.entity.MockTest;
import com.onlycgl.cgl.createMocktest.entity.Question;
import com.onlycgl.cgl.createMocktest.entity.QuestionTranslation;
import com.onlycgl.cgl.createMocktest.repository.MockTestRepository;
import com.onlycgl.cgl.createMocktest.repository.QuestionRepository;
import com.onlycgl.cgl.createMocktest.repository.QuestionTranslationRepository;
import com.onlycgl.cgl.userMocktest.dto.MockTestDetailDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MockTestDetailService {

    @Autowired
    private MockTestRepository mockTestRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionTranslationRepository questionTranslationRepository;

    public MockTestDetailDTO getMockTestDetail(Long mockTestId) {
        MockTest mockTest = mockTestRepository.findById(mockTestId).orElse(null);
        if (mockTest == null) {
            return null; // Or handle accordingly
        }

        List<Question> questions = questionRepository.findByMockTest(mockTest);

        List<MockTestDetailDTO.QuestionDTO> questionDTOs = questions.stream().map(question -> {
            List<QuestionTranslation> translations = questionTranslationRepository.findByQuestion(question);

            List<MockTestDetailDTO.QuestionTranslationDTO> translationDTOs = translations.stream().map(translation -> {
                MockTestDetailDTO.QuestionTranslationDTO dto = new MockTestDetailDTO.QuestionTranslationDTO();
                dto.setTranslationId(translation.getTranslationId());
                dto.setLanguageCode(translation.getLanguageCode());
                dto.setQuestionText(translation.getQuestionText());
                dto.setOptionA(translation.getOptionA());
                dto.setOptionB(translation.getOptionB());
                dto.setOptionC(translation.getOptionC());
                dto.setOptionD(translation.getOptionD());
                dto.setCorrectOption(translation.getCorrectOption());
                dto.setExplanation(translation.getExplanation());
                dto.setHint(translation.getHint());
                return dto;
            }).collect(Collectors.toList());

            MockTestDetailDTO.QuestionDTO questionDTO = new MockTestDetailDTO.QuestionDTO();
            questionDTO.setQuestionId(question.getQuestionId());
            questionDTO.setDifficultyLevel(question.getDifficultyLevel());
            questionDTO.setSubject(question.getSubject());
            questionDTO.setTagOrTopic(question.getTagOrTopic());
            questionDTO.setMarks(question.getMarks());
            questionDTO.setNegativeMarks(question.getNegativeMarks());
            questionDTO.setTranslations(translationDTOs);

            return questionDTO;
        }).collect(Collectors.toList());

        MockTestDetailDTO detailDTO = new MockTestDetailDTO();
        detailDTO.setMockTestId(mockTest.getMocktestId());
        detailDTO.setTitle(mockTest.getTitle());
        detailDTO.setDuration(mockTest.getDuration());
        detailDTO.setTotalQuestions(mockTest.getTotalQuestions());
        detailDTO.setQuestions(questionDTOs);

        return detailDTO;
    }
}
