<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div
		class="flex flex-col h-screen bg-gradient-to-r from-cyan-500 to-blue-500 items-center
		 justify-center text-center">
		<div class="border-4 p-10 rounded-3xl">
			<div class="text-white font-serif font-semibold text-6xl pb-6">Healthcare Login</div>
			<form method="post" action="login">
				<div class="flex flex-col text-white">

					<div class="text-2xl flex flex-col gap-2 p-2">
						<label for="userid" class="font-semibold">Username</label><input
							type="text" name="userid" required class="rounded-lg text-cyan-400 text-center p-2">
					</div>

					<div class="text-2xl flex flex-col w-full gap-2 p-2 pb-8">
						<label for="password">Password</label><input type="password"
							name="password" required class="rounded-lg text-cyan-400 text-center p-2">
					</div>

					<div class="flex flex-col ">
						<input type="submit" value="Login"
							class="text-2xl border-2 rounded-lg p-2 m-2"> <a
							href="registration"
							class="text-2xl border-2 rounded-lg p-2 m-2 bg-white text-cyan-400">Register</a>
					</div>

				</div>
			</form>
		</div>
	</div>
</body>
</html>
