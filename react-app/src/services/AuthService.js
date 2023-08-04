import axios from 'axios';

const BASE_URL = "http://127.0.0.1:8080";

const AuthService = {
  login: async (email, password) => {
    try {
      const response = await axios.post(`${BASE_URL}/login`, { email, password });
      return response.data;
    } catch (error) {
      throw error;
    }
  },
};

export default AuthService;