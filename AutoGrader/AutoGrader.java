import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Request;

import java.lang.reflect.Method;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Random;

public class AutoGrader {
	public static String feedback = "";
	public static int score = 0;

	public static void main(String[] args) {
		JUnitCore junit = new JUnitCore();

		// Might need to edit this object depending on the name of the JUnit
		ArrayListBagTest runner = new ArrayListBagTest();
        Method[] methods = runner.getClass().getMethods();

       	runTests(junit, methods);
       	runCheckstyle();
       	outputResults(args[0]);

		// Kills program if tests take too long; might cause problems if tests are supposed to take a long time. 
		System.exit(0);
	}

	/**
	 * Runs JUnit tests. Tests must be annotated with @Worth to run. Writes feedback to a file called
	 * comments.txt. This file must exist prior to this method being called. 
	 *
	 * @param JUnitCore junit The junit runner object.
	 * @param Method[] methods The array of Methods from the JUnit class file.
	 */
	public static void runTests(JUnitCore junit, Method[] methods) {
		for (Method method : methods) {
	    	// Worth will be null if method is not annotated with @Worth
	        Worth worth = method.getAnnotation(Worth.class);

	        if (worth != null) {
	    		Request request = Request.method(ArrayListBagTest.class, method.getName());

	            // Total the points from each JUnit test
	            if (junit.run(request).wasSuccessful()) score += worth.points();
				else feedback += worth.feedback() + " ";
	        }
	    }
	}

	/** 
	 * Counts number of lines in checkstyle.txt and deducts 1 point for each error.
	 */
	public static void runCheckstyle() {
		try (BufferedReader reader = new BufferedReader(new FileReader("checkstyle.txt"))) {
			// Checkstyle contains 2 lines by default
			int lines = -2;

			while (reader.readLine() != null) lines++;

			if (lines > 0) feedback += "-" + lines + " checkstyle errors. ";

			score -= lines;
		} catch (Exception e) {}
	}

	/**
	 * Writes score to temp.csv and outputs JUnit feedback to comments.txt. Also appends the TA's
	 * signature to the feedback based on TAs.txt. PrintWriter will close even if the try-statement 
	 * causes errors.
	 *
	 * @param String ta The name of the grading TA.
	 */
	public static void outputResults(String ta) {
    	// Prevent negative scores
		score = Math.max(score, 0);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("grade.txt", true)))) {
	        out.println(score);
		} catch (Exception e) {}

		feedback += selectComment(score) + " -" + ta;

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comments.txt", true)))) {
			out.print(feedback);
		} catch (Exception e) {}
	}

	/**
	 * Generates human-like comments. Edit goodScoreCutoff as needed.
	 *
	 * @param int grade The student's score.
	 */
	public static String selectComment(int score) {
		Random rand = new Random();
		int goodScoreCutoff = 35;

		String[] good = {
			"Great!", "Great job!", "Great work!", "Nice!", "Nice job!", "Nice work!", "Good!", "Good job!", 
			"Good work!", "Very good!", "Very nice code!", "Excellent!", "Excellent job!", "Excellent work!", 
			"Works great!", "Fantastic!", "Fantastic job!", "Fantastic work!", "Keep up the good work!", "Great!", 
			"Great job!", "Great work!", "Nice!", "Nice job!", "Nice work!", "Good!", "Good job!", "Good work!"
		};

		String[] bad = {
			"Looks like you lost a number of points. Next time if you need any help, please come to office hours!",
			"If there is any confusion, feel free to ask a TA for help.",
			"Feel free to send me an email or come by office hours if you need help with your code.",
			"If you are ever unsure of anything, please ask questions!",
			"If you need more clarification, please visit any TA during office hours.",
			"Make sure to read instructions carefully and ask questions if you are unsure of anything!",
			"Please ask for clarification any time you are unsure.",
			"Let me know if you need any help with homeworks in the future!",
			"Could be better. Please let me know if you need help!",
			"If you ever have questions, don't hesitate to ask for help!",
			"Be sure to follow instructions carefully in the future.",
			"If anything is unclear, feel free to ask for help!",
			"Feel free to email me or come to office hours if you need help!",
			"Don't hesitate to ask for help if you need it!",
			"Be sure to ask for help if you need it!",
			"Don't worry about asking for help if anything is unclear!",
			"Feel free to ask any TA for help if you need it!"
		};

		int index = Math.abs(rand.nextInt());
		return (score < goodScoreCutoff ? bad[index%bad.length] : good[index%good.length]);
	}
}	