import http from './axios-common';

export function getBondsByMaturity(){
    return http.get("/bonds/maturity");
}