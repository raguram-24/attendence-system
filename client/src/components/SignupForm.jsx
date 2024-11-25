import { useState } from 'react';
import { Form } from 'react-router-dom';

import classes from './Auth.module.css';

function SignupForm() {
  return (
    <>
      <Form method="post" className={classes.form}>
        <h1>Signup</h1>
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
          <button>Save</button>
        </div>
      </Form>
    </>
  );
}

export default SignupForm;
