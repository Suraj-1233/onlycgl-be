package com.onlycgl.cgl.userMocktest.dto;

import java.util.List;

public class QuestionDTO {

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
