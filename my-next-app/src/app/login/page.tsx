'use client'
import { useState } from "react";
import { FaEye } from "react-icons/fa";
import { FaEyeSlash } from "react-icons/fa";
export default function LoginPage() {
  const [showPassword, setShowPassword] = useState(false);
  return (
    
    <div
      className="flex items-center  justify-center bg-cover bg-center w-full"
      style={{
        backgroundImage: "url('/login.jpg')",
        height: "100vh",
        width: "100vw",
      }}
    >
      <div className="flex max-w-4xl items-center justify-center w-full rounded-xl overflow-hidden shadow-2xl bg-white opacity-90">
      
        {/* Left Side – SVG Image */}
        <div className="w-1/2 bg-slate-400 flex items-center  justify-center p-6">
          <h1 className="absolute left-56 font-bold text-black text-2xl ">Welcome back...</h1>
          <img
            src="/waiter.svg"
            alt="Waiter illustration"
            className="max-h-[400px] relative w-full "
          />
        </div>

        {/* Right Side – Login Form */}
        <div className="w-1/2 p-12 flex flex-col gap-6 justify-center">
          <h1 className="font-bold text-3xl text-center">Sign in</h1>

          <p className="text-sm text-gray-600 text-center">
            Don't have an account?{" "}
            <a href="#" className="text-blue-500 underline">
              Create now
            </a>
          </p>

          <form className="flex flex-col gap-4" action="#">
            <div className="flex flex-col">
              <label htmlFor="email" className="mb-1">
                Email
              </label>
              <input
                className="border ring-1 w-full p-2 rounded-sm"
                type="text"
                placeholder="Enter your email"
                required
              />
            </div>

            <div className="flex flex-col relative">
              <label htmlFor="password" className="mb-1">
                Password
              </label>
              <input
                className="border  ring-1 w-full p-2 rounded-sm"
                type={showPassword ? "text" : "password"}
                placeholder="Password"
                required
              />
               <span
                className="absolute right-3 top-10 text-gray-600 cursor-pointer"
                onClick={() => setShowPassword(!showPassword)}
              >
                {showPassword ? <FaEyeSlash /> : <FaEye />}
              </span>
            </div>

            <div className="flex items-center justify-between text-sm">
              <label className="flex items-center">
                <input type="checkbox" className="mr-1" />
                Remember Me
              </label>
              <a href="#" className="text-blue-500 underline">
                Forgot Password?
              </a>
            </div>

            <button
              type="submit"
              className="bg-green-800 hover:bg-green-900 p-2 rounded-2xl text-white font-semibold transition"
            >
              Sign in
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
