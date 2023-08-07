import http from './axios-common';

export function getAllTrades(){
    return http.get("/trades");
}