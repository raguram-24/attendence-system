import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import RootLayout from './pages/Root';
import Error from './pages/Error';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';

const router = createBrowserRouter([
  {
    path: '/',
    element: <RootLayout />,
    errorElement: <Error/>,
    children: [
      {   
        index: true,
        element: <Login/>,
      },
      {
        path: '/signup',
        element: <Signup/>,
      },
      {
        path: '/home',
        element: <Home/>,
      },
      // Add other routes here as needed
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;