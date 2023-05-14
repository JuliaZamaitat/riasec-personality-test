'use client';
import { useRouter } from 'next/navigation';
import { useState } from 'react';

interface PersonalDataFormProps {
  id: number;
}

const PersonalDataForm = ({ id }: PersonalDataFormProps) => {
  const router = useRouter();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    gender: 'Male',
  });
  const [isEmailValid, setIsEmailValid] = useState(true);

  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

  const handleSubmit = (e: any) => {
    e.preventDefault();

    const firstName = e.target.firstName.value;
    const lastName = e.target.lastName.value;
    const email = e.target.email.value;
    const gender = e.target.gender.value;

    localStorage.setItem('firstName', firstName);
    localStorage.setItem('lastName', lastName);
    localStorage.setItem('email', email);
    localStorage.setItem('gender', gender);

    router.push(`/tests/${id}/quiz`);
  };

  const handleChange = (
    e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>
  ) => {
    const { id, value } = e.target;

    if (id === 'email') {
      setIsEmailValid(emailRegex.test(value));
    }

    setFormData((prevFormData) => ({
      ...prevFormData,
      [id]: value,
    }));
  };

  const isFormValid = Object.values(formData).every((value) => value !== '');

  return (
    <>
      <h1 className="text-center font-bold text-[#f8f8f8] text-5xl mt-6 mb-20">
        Please fill in your personal details
      </h1>

      <div className="bg-white max-w-xl mx-auto mt-35 p-16">
        <form onSubmit={handleSubmit}>
          <div className="flex flex-wrap -mx-3 mb-6">
            <div className="w-full md:w-1/2 px-3 mb-6 md:mb-0">
              <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                First Name
              </label>
              <input
                className="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                id="firstName"
                type="text"
                value={formData.firstName}
                onChange={handleChange}
                placeholder="Jane"
              />
            </div>
            <div className="w-full md:w-1/2 px-3">
              <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Last Name
              </label>
              <input
                className="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                id="lastName"
                type="text"
                value={formData.lastName}
                onChange={handleChange}
                placeholder="Doe"
              />
            </div>
          </div>
          <div className="flex flex-wrap -mx-3 mb-6">
            <div className="w-full px-3">
              <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Email
              </label>
              <input
                className={`appearance-none block w-full bg-gray-200 text-gray-700 border ${
                  isEmailValid ? 'border-gray-200' : 'border-red-500'
                } rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white ${
                  isEmailValid
                    ? 'focus:border-gray-500'
                    : 'focus:border-red-500'
                }`}
                id="email"
                type="email"
                placeholder="mail@mail.de"
                value={formData.email}
                onChange={handleChange}
              />
              {!isEmailValid && (
                <p className="text-red-500 text-xs italic">
                  Please enter a valid email address.
                </p>
              )}
            </div>
          </div>
          <div className="flex flex-wrap -mx-3 mb-2">
            <div className="w-full md:w-1/3 px-3 mb-6 md:mb-0">
              <label className="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                Gender
              </label>
              <div className="relative">
                <select
                  className="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                  id="gender"
                  value={formData.gender}
                  onChange={handleChange}
                >
                  <option>Male</option>
                  <option>Female</option>
                  <option>Non-Binary</option>
                  <option>Other</option>
                </select>
                <div className="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                  <svg
                    className="fill-current h-4 w-4"
                    xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 20 20"
                  >
                    <path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
          <button
            type="submit"
            className={`bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded ${
              isFormValid ? '' : 'opacity-50 cursor-not-allowed'
            } ${isEmailValid ? '' : 'opacity-50 cursor-not-allowed'}`}
            disabled={!isFormValid || !isEmailValid}
          >
            Submit
          </button>
        </form>
      </div>
    </>
  );
};

export default PersonalDataForm;
