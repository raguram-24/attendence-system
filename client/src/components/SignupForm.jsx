import { useState } from 'react';
import { Form, useActionData } from 'react-router-dom';

import classes from './Auth.module.css';

function SignupForm() {
  const data = useActionData();
  return (
    <>
      <Form method="post" className={classes.form}>
      {data && data.errors && (
          <ul>
            {Object.values(data.errors).map((err) => (
              <li key={err}>{err}</li>
            ))}
          </ul>
        )}
        {data && data.message && <p>{data.message}</p>}
        <p>
          <label htmlFor="name">Name</label>
          <input id="name" type="text" name="name" required />
        </p>
        <p>
          <label htmlFor="username">Username</label>
          <input id="username" type="text" name="username" required />
        </p>
        <p>
          <label htmlFor="password">Password</label>
          <input id="password" type="password" name="password" required />
        </p>
        <div className={classes.actions}>
          <button>Register</button>
        </div>
      </Form>
    </>
  );
}

export default SignupForm;
