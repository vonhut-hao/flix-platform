import { api, API_BASE } from './api';

interface AuthResponse {
  accessToken: string;
  expiresIn: number;
}

interface LoginRequest {
  username: string;
  password: string;
}

interface RegisterRequest {
  username: string;
  email: string;
  password: string;
}

export const authService = {
  async login(data: LoginRequest): Promise<AuthResponse> {
    const res = await api.post<AuthResponse>('/v1/auth/login', data);
    localStorage.setItem('accessToken', res.result.accessToken);
    localStorage.setItem('expiresIn', String(res.result.expiresIn));
    return res.result;
  },

  async register(data: RegisterRequest): Promise<AuthResponse> {
    const res = await api.post<AuthResponse>('/v1/auth/register/normal', data);
    return res.result;
  },

  googleLogin(): void {
    window.location.href = `${API_BASE}/oauth2/authorization/google`;
  },

  logout(): void {
    localStorage.removeItem('accessToken');
    localStorage.removeItem('expiresIn');
    localStorage.removeItem('userId');
  },

  isAuthenticated(): boolean {
    return !!localStorage.getItem('accessToken');
  },

  getToken(): string | null {
    return localStorage.getItem('accessToken');
  },
};
