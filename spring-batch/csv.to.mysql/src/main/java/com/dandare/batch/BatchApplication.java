package com.dandare.batch;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
//@RequiredArgsConstructor
//@AllArgsConstructor
public class BatchApplication implements CommandLineRunner {

	@Autowired
	private Job job;

	@Autowired
	private JobLauncher jobLauncher;
	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Job Started : "+ LocalDateTime.now());

		JobParameters jobParameters = new JobParametersBuilder()
				.addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();

		jobLauncher.run(job, jobParameters);

		System.out.println("Job Finish : "+ LocalDateTime.now());


	}
}
