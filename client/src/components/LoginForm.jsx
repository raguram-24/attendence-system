import { useState } from 'react';
import { Form,Link,useSearchParams,useActionData } from 'react-router-dom';

import classes from './Auth.module.css';

function LoginForm() {
  const data = useActionData();
  return (
    <>
      <Form method="post" className={classes.form}>
        <h1>Login</h1>
        {data && data.errors && (
          <ul>
            {Object.values(data.errors).map((err) => (
              <li key={err}>{err}</li>
            ))}
          </ul>
        )}
        {data && data.message && <p>{data.message}</p>}
        <p>
          <label htmlFor="username">Username</label>
          <input id="username" type="text" name="username" required />
        </p>
        <p>
          <label htmlFor="password">Password</label>
          <input id="password" type="password" name="password" required />
        </p>
        <div className={classes.actions}>
          <button>Login</button>
        </div>
      </Form>
    </>
  );
}

export default LoginForm;
