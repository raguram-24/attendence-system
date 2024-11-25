import { useState } from 'react';
import { Form,Link,useSearchParams } from 'react-router-dom';

import classes from './Auth.module.css';

function LoginForm() {
  return (
    <>
      <Form method="post" className={classes.form}>
        <h1>Login</h1>
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

export default LoginForm;
