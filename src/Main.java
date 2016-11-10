/*
    Homework 3:
	Author: Oscar Ivan Ricaud.
	Instructor: Vladik Kreinovich,
	TA: Angel Garcia Contreras
	TA: Sheikh Motahar Naim
	CS 3350: Automata, Computability, and Formal Languages
	Data of Last modification Sept. 11th, 2016

    Program purpose:
	   (Due September 20, extra credit if turned in by September 13) Write a program that simulates a finite automaton
	    based on the user's specification. Your program should ask for:
        - the number n of states;
        - the states will be q1, q2, ..., qn;
        - the state q1 is the starting state;
        - ask the user to indicate, one by one, whether each of the states qi (1 ≤ i ≤ n) is an accept (final) state;
        - ask the user for the number s of symbols; symbols will be 0, 1, 2, ..., s − 1;
        - for each state and each symbol, ask the user for the number of the next state.

        Store the set of accept states in a boolean array accept of size n, and the next states in a 2-D array next.
        Once the automaton is formed, your program should be able to check whether a given string of digits is accepted
         by this automaton.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the number n of states");
        int numOfStates = read.nextInt();
        boolean [] accept = new boolean [numOfStates+1];
        for(int i = 1; i < accept.length; i++){
            System.out.println("Is state q" + i + " final? Y/N?");
            String answer = read.next();
            if(answer.charAt(0) == ('Y') || answer.charAt(0) == ('y')){
                accept[i] = true;
            }
        }
        System.out.println("How many symbols does your Automata have?");
        int numOfSymbols = read.nextInt();
        for(int i = 1 ; i <= numOfSymbols; i ++){
            System.out.println("Enter symbol " + i + ":");
            Object nameOfSymbols = read.next();
        }
        int [][] next_ = new int[numOfStates+1][numOfStates+1];

        for(int stateWeAreIn =1; stateWeAreIn <= numOfSymbols; stateWeAreIn++){
            for(int symbolWeRead = 0; symbolWeRead < numOfSymbols; symbolWeRead++) {
                System.out.println("From state q" + stateWeAreIn + " we read symbol " + symbolWeRead + ", enter the " +
                        "state number you end up in.");
                 int symbol_read = read.nextInt();
                 next_[stateWeAreIn][symbolWeRead] = symbol_read;
            }
        }
        // Prints state's information
        for(int stateWeAreIn =1; stateWeAreIn <= numOfSymbols; stateWeAreIn++){
            for(int symbolWeRead = 0; symbolWeRead < numOfSymbols; symbolWeRead++) {
                System.out.println("next_[" + stateWeAreIn + "][" + symbolWeRead + "] = " + next_[stateWeAreIn][symbolWeRead]);
            }
        }


        System.out.println("Enter the digits of the sample data ");
        String data = read.next();
        int state = 1;

        for(int k = 0 ; k < data.length(); k++) {
            String single = Character.toString(data.charAt(k));
            int convert = Integer.parseInt(single);
            state = next_[state][convert];
        }
            if(accept[state]){
                System.out.println(" The given string of digits is accepted by this automaton.\n");
            }
            else {
                System.out.println(" The given string of digits is NOT accepted by this automaton.\n");
            }
    }
}
