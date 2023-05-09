import TestList from '../../components/TestList';
import getTests from '../util/tests';

export const dynamic = 'force-dynamic';

export default async function Tests() {
  const tests = await getTests();
  console.log(tests._embedded.hollandCodeTests);

  return (
    <div>
      <TestList tests={tests._embedded.hollandCodeTests} />
      <h1>Verfügbare Tests222 test</h1>
      {/* <p>{tests}</p> */}
    </div>
  );
}
