import TestList from '../../components/TestList';
import getTests from '../util/tests';

export const dynamic = 'force-dynamic';

export default async function Tests() {
  const tests = await getTests();

  return (
    <>
      <h1 className="text-center font-bold text-[#f8f8f8] text-6xl mt-6 mb-20">
        Available Tests
      </h1>
      <TestList tests={tests._embedded.hollandCodeTests} />
    </>
  );
}
