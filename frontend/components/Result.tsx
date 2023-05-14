import { useEffect, useState } from 'react';
import { getResult } from '../app/util/result';

interface IProfession {
  id: number;
  title: string;
  hollandCode: string;
}

interface IData {
  hollandCode: string;
  exactProfessions: IProfession[];
  similarProfessions: IProfession[];
}

export default function Result({ answers }: { answers: any }) {
  const [data, setData] = useState<null | IData>(null);
  const [isLoading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);
    getResult(answers).then((data: IData) => {
      setData(data);
      setLoading(false);
    });
  }, []);

  if (isLoading) return <p>Loading...</p>;
  if (!data) return <p>No data</p>;

  return (
    <div>
      <h1>Your Holland-Code: {data.hollandCode}</h1>
      <h2>Exact Professions:</h2>
      <div>
        {data.exactProfessions.map((prof: any) => {
          return <p key={prof.id}>{prof.title}</p>;
        })}
      </div>
      <h2>Similar Professions:</h2>
      <div>
        {data.similarProfessions.map((prof: any) => {
          return (
            <p key={prof.id}>
              {prof.title}, {prof.hollandCode}
            </p>
          );
        })}
      </div>
    </div>
  );
}
