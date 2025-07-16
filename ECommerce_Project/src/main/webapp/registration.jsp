<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration - Page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
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
        font-size: 32px;
        font-weight: bold;
    }

    .input-box {
        position: relative;
        margin-bottom: 25px;
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
</head>
<body>

<section>
    <div class="login-box">
        <form action="registerUser" method="post">
            <h1>Registration</h1>

            <div class="input-box">
                <input type="text" name="id" required>
                <label>ID</label>
                <span class="icon"><i class="fas fa-id-badge"></i></span>
            </div>

            <div class="input-box">
                <input type="text" name="name" required>
                <label>Name</label>
                <span class="icon"><i class="fas fa-user"></i></span>
            </div>

            <div class="input-box">
                <input type="email" name="email" required>
                <label>Email</label>
                <span class="icon"><i class="fas fa-envelope"></i></span>
            </div>

            <div class="input-box">
                <input type="password" name="password" required>
                <label>Password</label>
                <span class="icon"><i class="fas fa-lock"></i></span>
            </div>

            <div class="input-box">
                <input type="text" name="phoneNumber" required>
                <label>Phone Number</label>
                <span class="icon"><i class="fas fa-phone"></i></span>
            </div>

            <div class="input-box">
                <input type="text" name="role" required>
                <label>Role</label>
                <span class="icon"><i class="fas fa-user-tag"></i></span>
            </div>
            <div class="input-box">
                <input type="text" name="address" required>
                <label>Address</label>
                <span class="icon"><i class="fas fa-user-tag"></i></span>
            </div>

            <div class="submit">
                <button type="submit">Sign Up</button>
            </div>

            <div class="register-link">
                <p>Already have an account? <a href="login.jsp">Sign in</a></p>
            </div>
        </form>
    </div>
</section>

</body>
</html>
