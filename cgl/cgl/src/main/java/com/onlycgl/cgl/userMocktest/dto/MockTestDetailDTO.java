package com.onlycgl.cgl.userMocktest.dto;

import java.util.List;

public class MockTestDetailDTO {

    private Long mockTestId;
    private String title;
    private Integer duration;
    private Integer totalQuestions;
    private List<QuestionDTO> questions;

    // Getters and Setters

    public Long getMockTestId() {
        return mockTestId;
    }

    public void setMockTestId(Long mockTestId) {
        this.mockTestId = mockTestId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public static class QuestionDTO {
        private Integer questionId;
        private String difficultyLevel;
        private String subject;
        private String tagOrTopic;
        private int marks;
        private int negativeMarks;
        private List<QuestionTranslationDTO> translations;

        // Getters and Setters

        public Integer getQuestionId() {
            return questionId;
        }

        public void setQuestionId(Integer questionId) {
            this.questionId = questionId;
        }

        public String getDifficultyLevel() {
            return difficultyLevel;
        }

        public void setDifficultyLevel(String difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTagOrTopic() {
            return tagOrTopic;
        }

        public void setTagOrTopic(String tagOrTopic) {
            this.tagOrTopic = tagOrTopic;
        }

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public int getNegativeMarks() {
            return negativeMarks;
        }

        public void setNegativeMarks(int negativeMarks) {
            this.negativeMarks = negativeMarks;
        }

        public List<QuestionTranslationDTO> getTranslations() {
            return translations;
        }

        public void setTranslations(List<QuestionTranslationDTO> translations) {
            this.translations = translations;
        }
    }

    public static class QuestionTranslationDTO {
        private Integer translationId;
        private String languageCode;
        private String questionText;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String correctOption;
        private String explanation;
        private String hint;

        // Getters and Setters

        public Integer getTranslationId() {
            return translationId;
        }

        public void setTranslationId(Integer translationId) {
            this.translationId = translationId;
        }

        public String getLanguageCode() {
            return languageCode;
        }

        public void setLanguageCode(String languageCode) {
            this.languageCode = languageCode;
        }

        public String getQuestionText() {
            return questionText;
        }

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public String getOptionA() {
            return optionA;
        }

        public void setOptionA(String optionA) {
            this.optionA = optionA;
        }

        public String getOptionB() {
            return optionB;
        }

        public void setOptionB(String optionB) {
            this.optionB = optionB;
        }

        public String getOptionC() {
            return optionC;
        }

        public void setOptionC(String optionC) {
            this.optionC = optionC;
        }

        public String getOptionD() {
            return optionD;
        }

        public void setOptionD(String optionD) {
            this.optionD = optionD;
        }

        public String getCorrectOption() {
            return correctOption;
        }

        public void setCorrectOption(String correctOption) {
            this.correctOption = correctOption;
        }

        public String getExplanation() {
            return explanation;
        }

        public void setExplanation(String explanation) {
            this.explanation = explanation;
        }

        public String getHint() {
            return hint;
        }

        public void setHint(String hint) {
            this.hint = hint;
        }
    }
}
