import { redirect } from 'react-router-dom';  // Make sure this import exists

export async function action({request}){
    const data = await request.formData();
    const authData = {
      name: data.get('name'),  
      username: data.get('username'),
      password: data.get('password')
    };
  
    try {
      const response = await fetch('http://localhost:8080/api/register', {
        method: "POST",
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(authData)
      });

      if (response.status === 422 || response.status === 401) {
        return response;
      }
    
      if (!response.ok) {
        throw new Error('Error in Creating user');
      }
      
      // Store any necessary data in localStorage if needed
      // localStorage.setItem('token', data.token);
      console.log(response);
      return redirect('/');  // Make sure this path matches your route configuration
    } catch (error) {
      throw new Response(JSON.stringify({ message: error.message }), { status: 500 });
    }
}