package com.quiz.bitmesra;

import com.quiz.bitmesra.model.Quiz;
import com.quiz.bitmesra.model.User;
import com.quiz.bitmesra.repository.QuizRepository;
import com.quiz.bitmesra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@SpringBootApplication
public class BitmesraApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private QuizRepository quizRepository;

	public static void main(String[] args) {
		SpringApplication.run(BitmesraApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		saveQuizInDB();
		User user = readAndSaveUser();
		System.out.println("Press 1 for demo and any key for actual quiz");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		String input = reader.readLine();

		if("1".equals(input)){
			demoQuiz(user);
		}else{
			actualQuiz(user);
		}

	}

	public User readAndSaveUser() throws IOException{
		System.out.println("Enter name");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		String name = reader.readLine();
		System.out.println("Enter Email ID");
		String email = reader.readLine();
		User user = new User();
		user.setName(name);
		user.setEmailId(email);
		return userRepository.save(user);
	}

	public void saveQuizInDB(){
		Quiz quiz = new Quiz();
		quiz.setQuestion("Who developed Java?");
		quiz.setAnswer("James Gosling");

		Quiz quiz1 = new Quiz();
		quiz.setQuestion("Who developed Java?");
		quiz.setAnswer("James Gosling");

		Quiz quiz2 = new Quiz();
		quiz.setQuestion("Who developed Java?");
		quiz.setAnswer("James Gosling");

		Quiz quiz3 = new Quiz();
		quiz.setQuestion("Who developed Java?");
		quiz.setAnswer("James Gosling");

		quizRepository.save(quiz);
		quizRepository.save(quiz1);
		quizRepository.save(quiz2);
		quizRepository.save(quiz3);
	}

	public void demoQuiz(User user) throws IOException {
		Quiz quiz = quizRepository.findAll().get(0);
		System.out.println(quiz.getQuestion());
		System.out.println("Type Answer");
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));

		String answer = reader.readLine();

		if(answer.equalsIgnoreCase(quiz.getAnswer())){
			user.setScore(10);
		}else{
			user.setScore(0);
		}
		System.out.println(user);
		userRepository.save(user);
	}

	public void actualQuiz(User user) throws IOException {
		List<Quiz> quizList = quizRepository.findAll();
		int score = 0;
		for ( Quiz q : quizList){
			System.out.println(q.getQuestion());
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));

			String answer = reader.readLine();

			if(answer.equalsIgnoreCase(q.getAnswer())){
				score += 10;
			}else{
				user.setScore(score);
				User savedUser = userRepository.save(user);
				System.out.println(savedUser);
				break;
			}
		}
	}

}
