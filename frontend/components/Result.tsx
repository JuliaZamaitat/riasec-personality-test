import { useEffect, useState } from 'react';
import { getResult } from '../app/util/result';

interface IData {
  text: string;
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
      <h1>Your Holland-Code: {data.text}</h1>
    </div>
  );
}
