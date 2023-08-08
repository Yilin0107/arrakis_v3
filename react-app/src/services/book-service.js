import http from './axios-common';

export function getAllBooks(emp_id){
    return http.get(`/employees/books/${emp_id}`);
}