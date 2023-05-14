'use client';
import PersonalDataForm from '../../../components/PersonalDataForm';
export default async function TestStart({
  params: { id },
}: {
  params: { id: number };
}) {
  return <PersonalDataForm id={id} />;
}
