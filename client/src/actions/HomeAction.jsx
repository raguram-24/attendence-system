import { getAuthToken } from "../util/Auth";

export async function action(){
    const respone = await fetch('http://localhost:8080/api/home',{
        method: 'GET',
        headers : {
            'Authorization':'Bearer' + getAuthToken()
        }
    })
}