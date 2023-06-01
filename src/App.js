import React, { useState, useEffect } from "react";
import * as Components from './Components/Auth_Components';
import ForgotPasswordPage from "./Components/ForgotPasswordPage";


function App() {
  const [signIn, toggle] = React.useState(true);
  const [showForgotPassword, setShowForgotPassword] = React.useState(false);

  const handleForgotPasswordClick = () => {
    setShowForgotPassword(true);
  };

  const handleGoBackClick = () => {
    setShowForgotPassword(false);
  };


  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  
  const initialEmail = "";
  const initialPassword = "";

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  useEffect(() => {
    setEmail(initialEmail);
    setPassword(initialPassword);
  }, []);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Handle form submission logic
  };
  

  return (
    <Components.Container>
      <Components.SignUpContainer signinIn={signIn}>
        <Components.Form>
          <Components.Title>Create Account</Components.Title>
          <Components.Input type='text'  placeholder='Name' />
          <Components.Input type='email' placeholder='Email' />
          <Components.Input type='password' placeholder='Password' />
          <Components.Button>Sign Up</Components.Button>
        </Components.Form>
      </Components.SignUpContainer>

      <Components.SignInContainer signinIn={signIn}>
        {!showForgotPassword ? (
          <Components.Form onSubmit={handleSubmit}>
            <Components.Title>Sign in</Components.Title>
            <Components.Input type='email' value={email} onChange={handleEmailChange} placeholder='Email' />
            <Components.Input type='password' value={password} onChange={handlePasswordChange} placeholder='Password' />
            <Components.Anchor href="#" onClick={handleForgotPasswordClick}>
              Forgot your password?
            </Components.Anchor>
            <Components.Button>Sigin In</Components.Button>
          </Components.Form>
        ) : (
          <ForgotPasswordPage onGoBackClick={handleGoBackClick} />
        )}
      </Components.SignInContainer>

      <Components.OverlayContainer signinIn={signIn}>
        <Components.Overlay signinIn={signIn}>
          <Components.LeftOverlayPanel signinIn={signIn}>
            <Components.Title>Welcome Back!</Components.Title>
            <Components.Paragraph>
              To keep connected with us please login with your personal account!
            </Components.Paragraph>
            <Components.GhostButton onClick={() => toggle(true)}>
              Sign In
            </Components.GhostButton>
          </Components.LeftOverlayPanel>

          <Components.RightOverlayPanel signinIn={signIn}>
            <Components.Title>Hello, Friend!</Components.Title>
            <Components.Paragraph>
              Enter your personal details to sign up with us!
            </Components.Paragraph>
            <Components.GhostButton onClick={() => toggle(false)}>
              Sigin Up
            </Components.GhostButton>
          </Components.RightOverlayPanel>
        </Components.Overlay>
      </Components.OverlayContainer>
    </Components.Container>
  );
}

export default App;
