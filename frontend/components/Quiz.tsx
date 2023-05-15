'use client';

import { useState } from 'react';
import Result from './Result';

export default function Quiz(props: IQuizProps) {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [answers, setAnswers] = useState<Array<IQuestionAnswers>>([]);
  const currentQuestion = props.questions
    ? props.questions[currentQuestionIndex]
    : null;
  const [showResult, setShowResult] = useState(false);

  const handleAnswerClick = (answer: boolean) => {
    if (!currentQuestion) {
      return;
    }
    setAnswers((prevAnswers) => {
      const updatedAnswers = [...prevAnswers];
      const answeredQuestion: IQuestionAnswers = {
        questionAnswers: new Map([[currentQuestion, answer]]),
      };
      updatedAnswers[currentQuestionIndex] = answeredQuestion;
      return updatedAnswers;
    });

    const nextQuestionIndex = currentQuestionIndex + 1;

    if (nextQuestionIndex < props.questions?.length) {
      setCurrentQuestionIndex(nextQuestionIndex);
    } else {
      setShowResult(true);
    }
  };
  return (
    <>
      {!showResult && (
        <div className="max-w-2xl mx-auto ">
          <h1 className="text-center font-bold text-[#f8f8f8] text-5xl pt-6 mb-24">
            Holland Code Test
          </h1>
          <div className="flex flex-col border-solid border-2 rounded-md items-center">
            <h4 className="mt-10 text-xl text-white/70">
              Question {currentQuestionIndex + 1} of {props.questions?.length}
            </h4>
            <div className="mt-8 text-2xl text-white">
              {currentQuestion?.text}
            </div>
            <div className="flex py-6 m-10 space-x-8 cursor-pointer">
              <div className="flex items-center">
                <input
                  type="radio"
                  className="w-6 h-6"
                  name="answer"
                  key={`yes-${currentQuestionIndex}`}
                  onClick={() => handleAnswerClick(true)}
                />
                <label className="text-white ml-2">Yes</label>
              </div>
              <div className="flex items-center">
                <input
                  type="radio"
                  className="w-6 h-6"
                  name="answer"
                  key={`no-${currentQuestionIndex}`}
                  onClick={() => handleAnswerClick(false)}
                />
                <label className="text-white ml-2">No</label>
              </div>
            </div>
          </div>
        </div>
      )}

      {showResult && <Result testId={props.testId} answers={answers} />}
    </>
  );
}
