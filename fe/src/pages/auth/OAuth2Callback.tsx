import { useEffect } from "react";
import { useNavigate, useSearchParams } from "react-router";

export default function OAuth2Callback() {
  const navigate = useNavigate();
  const [searchParams] = useSearchParams();

  useEffect(() => {
    const token = searchParams.get("token");
    const expiresIn = searchParams.get("expiresIn");

    if (token) {
      localStorage.setItem("accessToken", token);
      if (expiresIn) {
        localStorage.setItem("expiresIn", expiresIn);
      }
      navigate("/profile", { replace: true });
    } else {
      // OAuth failed or no token — go back to sign in
      navigate("/signin", { replace: true });
    }
  }, [searchParams, navigate]);

  return (
    <div className="min-h-screen flex items-center justify-center bg-[#fafaf5]">
      <div className="flex flex-col items-center gap-4">
        <div className="w-10 h-10 border-4 border-[#25521f] border-t-transparent rounded-full animate-spin" />
        <p className="text-[#42493e] text-[16px]">Đang xác thực...</p>
      </div>
    </div>
  );
}
