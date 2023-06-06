<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>
	<div
		class="flex flex-col h-screen bg-gradient-to-r from-cyan-500 to-blue-500">
		<nav
			class="flex items-center justify-between flex-wrap bg-transperent p-6 border-2">
			<div class="flex items-center flex-shrink-0 text-white mr-6">
				<svg class="fill-current h-8 w-8 mr-2" width="54" height="54"
					viewBox="0 0 54 54" xmlns="http://www.w3.org/2000/svg">
					<path
						d="M13.5 22.1c1.8-7.2 6.3-10.8 13.5-10.8 10.8 0 12.15 8.1 17.55 9.45 3.6.9 6.75-.45 9.45-4.05-1.8 7.2-6.3 10.8-13.5 10.8-10.8 0-12.15-8.1-17.55-9.45-3.6-.9-6.75.45-9.45 4.05zM0 38.3c1.8-7.2 6.3-10.8 13.5-10.8 10.8 0 12.15 8.1 17.55 9.45 3.6.9 6.75-.45 9.45-4.05-1.8 7.2-6.3 10.8-13.5 10.8-10.8 0-12.15-8.1-17.55-9.45-3.6-.9-6.75.45-9.45 4.05z" /></svg>
				<span class="font-semibold text-xl tracking-tight">Healthcare
					Dashboard </span>
			</div>
			<div>
				<a href="#"
					class="inline-block text-sm px-4 py-2 leading-none border rounded 
      text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-white mt-4 lg:mt-0">Logout</a>
			</div>

		</nav>

		<div class="flex flex-auto text-white items-center justify-center ">

			<div class="flex justify-center gap-20">
				<div
					class="h-64 w-64 bg-gradient-to-r from-pink-500 to-yellow-500  rounded-full flex items-center justify-center text-white text-lg font-bold border-2"><a href="users">User Manager</a></div>
				<div
					class="h-64 w-64 bg-gradient-to-r from-pink-500 to-yellow-500 rounded-full flex items-center justify-center text-white text-lg font-bold border-2">Master</div>
			</div>


		</div>
	</div>

</body>
</html>