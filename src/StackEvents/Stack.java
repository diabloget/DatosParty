package StackEvents;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stack {
    private Stack(){
        stackArray = newStack ();
    }
    public static Stack getStack(){
        if(instance == null){
            return new Stack ();
        }else{
            return instance;
        }
    }

    private static Stack instance = null;
    int maxSize;
    private String[] stackArray = {"duel","duel","duel","duel","duel","duel","duel","duel","duel","duel","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","stealCoins","gveAwayCoins","gveAwayCoins","gveAwayCoins","gveAwayCoins","gveAwayCoins","looseStar","2Stars","2Stars","2Stars","5Stars","stealStar","stealStar","stealStar","teletransport","teletransport","teletransport","teletransport","teletransport","teletransport","teletransport","teletransport","teletransport","teletransport","switchPlaces","switchPlaces","switchPlaces","switchPlaces","switchPlaces"};
    private int top;


    private String[] newStack(){
        List<String> shuffle =Arrays.asList (stackArray);
        Collections.shuffle (shuffle);
        shuffle.toArray (stackArray);
        return newStack ();
    }

    public void push (String data) throws Exception {
        if(top<maxSize){
            this.stackArray[++top] = data;
        }else{

        }
    }

    public String pop(){
        String temp = stackArray[top--];
        if(temp == null){
            stackArray = newStack ();
            return stackArray[top--];
        }else{
            return  temp;
        }
    }

    public String peek(){
        return stackArray[top];
    }



}
