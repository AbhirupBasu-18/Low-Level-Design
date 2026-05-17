package com.abhirup.patterns.creational.singleton;

public class JudgeAnalystic {
    private static final JudgeAnalystic judgeAnalystic = new JudgeAnalystic();
    private JudgeAnalystic(){

    }
    public static JudgeAnalystic getInstance(){
        return judgeAnalystic;
    }
}
