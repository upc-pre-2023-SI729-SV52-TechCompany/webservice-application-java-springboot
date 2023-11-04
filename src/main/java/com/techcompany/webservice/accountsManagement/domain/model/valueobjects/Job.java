package com.techcompany.webservice.accountsManagement.domain.model.valueobjects;

public record Job(String job) {
    public Job() {
        this(null);
    }

    public Job {
        if (job == null) {
            throw new IllegalArgumentException("Job cannot be null");
        }
    }

    public String getJob() {
        return job;
    }
}
