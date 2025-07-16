<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
</head>
<body>

    <div class="content-spacing"></div>

    <section>
        <div class="login-box">
            <form action="login" method="post">
                <h1>Login</h1>
                <div class="input-box">
                    <input type="email" required name="email">
                    <span class="icon"><i class="fas fa-envelope"></i></span>
                    <label>Email</label>
                </div>
                <div class="input-box">
                    <input type="password" required name="password">
                    <span class="icon"><i class="fas fa-lock"></i></span>
                    <label>Password</label>
                </div>
                <div class="submit"><button type="submit">Sign In</button></div>
                <div class="register-link">
                    <p>Don't have an account? <a href="registration.jsp">Sign Up</a></p>
                </div>
            </form>
        </div>
    </section>
</body>
</html>

<style>
    body, h2, p, a {
        margin: 0;
        padding: 0;
        font-family: 'Arial', sans-serif;
        box-sizing: border-box;
    }

    body {
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
        background: #f0f2f5;
        flex-direction: column;
        color: #1a237e;
    }

    .login-box {
        width: 400px;
        padding: 30px;
        background-color: #ffffff;
        border-radius: 10px;
        color: #1a237e;
        box-shadow: 0 0 40px rgba(0, 0, 0, 0.2);
        text-align: center;
        border: 2px solid #ff6f00;
    }

    .login-box h1 {
        margin-bottom: 30px;
        font-size: 36px;
        font-weight: bold;
    }

    .input-box {
        position: relative;
        margin-bottom: 35px;
        width: 80%;
        margin-left: auto;
        margin-right: auto;
    }

    .input-box input {
        width: 100%;
        padding: 10px 40px 10px 15px;
        font-size: 18px;
        border-radius: 8px;
        border: 1px solid #ccc;
        color: #1a237e;
    }

    .input-box label {
        position: absolute;
        top: 8px;
        left: 15px;
        transition: 0.3s;
        font-size: 16px;
        pointer-events: none;
        color: #1a237e;
    }

    .input-box input:focus ~ label,
    .input-box input:valid ~ label {
        top: -18px;
        left: 5px;
        font-size: 14px;
        background-color: #ffffff;
        padding: 0 5px;
        color: #ff6f00;
    }

    .input-box .icon {
        position: absolute;
        top: 10px;
        right: 10px;
        font-size: 18px;
        color: #1a237e;
    }

    .submit button {
        width: 50%;
        padding: 10px;
        border: none;
        background-color: #ff6f00;
        color: white;
        font-size: 18px;
        border-radius: 8px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .submit button:hover {
        background-color: #e65100;
    }

    .register-link p {
        margin-top: 20px;
        color: #1a237e;
        font-size: 16px;
    }

    .register-link p a {
        color: #ff6f00;
        font-weight: bold;
        text-decoration: underline;
    }

    .register-link p a:hover {
        color: #e65100;
    }
</style>
