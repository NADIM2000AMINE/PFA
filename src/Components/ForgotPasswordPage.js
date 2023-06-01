import React, { useState } from "react";
import { Container, Form, Title, Input, Button, Anchor } from './Auth_Components';

function ForgotPasswordPage({ onGoBackClick }) {
  const [email, setEmail] = useState("");

  const handleGoBack = (event) => {
    event.preventDefault();
    onGoBackClick();
  };

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
    <Container style={{ position: "relative", overflow: "hidden", height: "100%" }}>
      <Form onSubmit={handleFormSubmit} style={{ textAlign: 'center' }}> 
        <Title>Forgot Password</Title>
        <Input
          type="email"
          placeholder="Email"
          value={email}
          onChange={handleEmailChange}
          required
        />
        <Button type="submit">Reset Password</Button>
        <Anchor href="#" onClick={handleGoBack}>
          Go back to Sign In?
        </Anchor>
      </Form>
    </Container>
  );
}

export default ForgotPasswordPage;
