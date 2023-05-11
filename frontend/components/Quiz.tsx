'use client';

import { useState } from 'react';

export default function Quiz(props: IQuestionsProps) {
  const [currentQuestionIndex, setCurrentQuestionIndex] = useState(0);
  const [answers, setAnswers] = useState<Array<string>>([]);
  const currentQuestion = props.questions
    ? props.questions[currentQuestionIndex]
    : null;

  const handleAnswerClick = (answer: string) => {
    // Store the answer in the answers array
    setAnswers((prevAnswers) => {
      const updatedAnswers = [...prevAnswers];
      updatedAnswers[currentQuestionIndex] = answer;
      return updatedAnswers;
    });

    const nextQuestionIndex = currentQuestionIndex + 1;

    if (nextQuestionIndex < props.questions?.length) {
      setCurrentQuestionIndex(nextQuestionIndex);
    } else {
      // Handle quiz completion logic here
      console.log('Quiz completed!', answers);
    }
  };

  return (
    <div className="max-w-2xl mx-auto">
      {props.questions?.map((question: any) => {
        return <h1 key={question.id}>{question.text}</h1>;
      })}
      <div className="flex flex-col mt-32 border-solid border-2 rounded-md items-center">
        <h4 className="mt-10 text-xl text-white/70">Question 1 of 5</h4>
        <div className="mt-8 text-2xl text-white">{currentQuestion?.text}</div>
        <div className="flex py-10 m-10 space-x-8 cursor-pointer">
          <div className="flex items-center">
            <input
              type="radio"
              className="w-6 h-6"
              name="answer"
              key={`yes-${currentQuestionIndex}`} // Add unique key
              onClick={() => handleAnswerClick('Yes')}
            />
            <label className="text-white ml-2">Yes</label>
          </div>
          <div className="flex items-center">
            <input
              type="radio"
              className="w-6 h-6"
              name="answer"
              key={`no-${currentQuestionIndex}`} // Add unique key
              onClick={() => handleAnswerClick('No')}
            />
            <label className="text-white ml-2">No</label>
          </div>
        </div>
      </div>
    </div>
  );
}
