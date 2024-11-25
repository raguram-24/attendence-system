import SignupForm from '../components/SignupForm';

const Signup = () => {
  return <SignupForm />;
};

export default Signup;

export async function action({request}){
   
  const data = await request.formData();
  const authData = {
    name : data.get('name'),  
    email:data.get('username'),
    password : data.get('password')
  };

  const response = await fetch('http://localhost:8080/api/register', {
    method:"POST",
    headers : {
        'Content-Type' : 'application/json',
    },
    body : JSON.stringify(authData)
  });
  if(response.status == 422 || response.status == 401){
    return response;
  }

  if(!response.ok){
    throw new Response(JSON.stringify({message:"Could not Authenticate User"},{status:500}));

  }
  return redirect('/')
}