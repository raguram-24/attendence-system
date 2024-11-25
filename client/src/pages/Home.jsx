import { useState, useEffect } from "react";
import PageContent from "../components/PageContent";
function Home() {
    const [message, setMessage] = useState('');
    const [error, setError] = useState(null);
    
    useEffect(() => {
        const token = localStorage.getItem('token');
        
        fetch('http://localhost:8080/api/home', {  // This URL should now work
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        })
        .then(res => res.text())  // Changed to text() since we're returning a String
        .then(message => {
            setMessage(message);
        })
        .catch(error => {
            console.error('Error:', error);
            setError(error.message);
        });
    }, []);

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <PageContent title="Welcome!">
            <p>{message || 'Loading...'}</p>
        </PageContent>
    );
}

export default Home;