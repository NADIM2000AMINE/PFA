import React, { useState } from "react";
import * as Components from './Auth_Components';

function ForgotPasswordPage() {
  const [email, setEmail] = useState("");

  const handleFormSubmit = (e) => {
    e.preventDefault();
    // Add your logic to handle the form submission for password reset
    console.log("Reset password for email:", email);
    // Clear the email input after submission
    setEmail("");
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  return (
    <Components.Container>
      <Components.Form onSubmit={handleFormSubmit}>
        <Components.Title>Forgot Password</Components.Title>
        <Components.Input
          type="email"
          placeholder="Email"
          value={email}
          onChange={handleEmailChange}
          required
        />
        <Components.Button type="submit">Reset Password</Components.Button>
      </Components.Form>
    </Components.Container>
  );
}

export default ForgotPasswordPage;
