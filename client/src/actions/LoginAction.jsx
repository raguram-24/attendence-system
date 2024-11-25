import { redirect } from 'react-router-dom';  // Make sure this import exists

export async function action({request}){
    const data = await request.formData();
    const authData = { 
      username: data.get('username'),
      password: data.get('password')
    };
    console.log(authData)
  
    try {
      const response = await fetch('http://localhost:8080/api/login', {
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
        },
        body:JSON.stringify(authData)
      });

      if (response.status === 422 || response.status === 401) {
        return response;
      }
    
      if (!response.ok) {
        throw new Error('Could not authenticate user');
      }
      const resData = await response.json();
      const token = resData.token;

      localStorage.setItem('token', token);     
      
      // Store any necessary data in localStorage if needed
      // localStorage.setItem('token', data.token);
      
      return redirect('/home');  // Make sure this path matches your route configuration
    } catch (error) {
      throw new Response(JSON.stringify({ message: error.message }), { status: 500 });
    }
}