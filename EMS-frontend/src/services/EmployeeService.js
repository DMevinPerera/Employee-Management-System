import axios from "axios";

const REST_API_BASE_URL = "http://localhost:8080/api/employees";

// Refactor to use async/await for better error handling and readability
export const listEmployees = async () => {
  try {
    const response = await axios.get(REST_API_BASE_URL);
    return response; // Return the full response object (including data)
  } catch (error) {
    console.error("Error fetching employees:", error);
    throw error; // Rethrow the error for the caller to handle
  }
};