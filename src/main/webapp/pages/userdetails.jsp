<%@page import="com.model.UserProfile"%>
<%@page import="com.model.State"%>
<%@page import="com.model.City"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Userdetail Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<%
ArrayList<City> citylist = (ArrayList<City>) request.getAttribute("citylist");
ArrayList<State> statelist = (ArrayList<State>) request.getAttribute("statelist");
UserProfile user = (UserProfile) request.getAttribute("profile");
%>
<body>

	<div
		class="flex flex-col h-screen bg-gradient-to-r from-cyan-500 to-blue-500 items-center
		 justify-center">
		<div class="border-4 p-10 rounded-3xl">
			<div class="text-white font-semibold font-serif text-6xl pb-10">Edit
				User Details</div>
			<form action="updateuser">
				<input type="hidden" name="id" value="<%=user.getId()%>">
				<div class="flex flex-col gap-2 text-white text-xl">

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="firstname">Firstname:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<input type="text" name="firstname" class="w-full"
								value="<%=user.getFirstname()%>" required>
						</div>
					</div>

					<div class="flex flex-row w-full pb-2">
						<div class="text-center w-1/2">
							<label for="lastname">Lastname:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<input type="text" name="lastname" class="w-full"
								value="<%=user.getLastname()%>" required>
						</div>
					</div>

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="address">Address:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<textarea rows="3" name="address" required
								class="w-max resize-none"><%=user.getAddress()%></textarea>
						</div>
					</div>

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="contact">Contact:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<input type="text" name="contact" class="w-full"
								value="<%=user.getContact()%>" required>
						</div>
					</div>

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="email">Email:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<input type="text" name="email" class="w-full"
								value="<%=user.getEmail()%>" required>
						</div>
					</div>


					<div class="flex flex-row">
						<div class="w-1/2 text-center">Select Gender :</div>
						<div>
							<label for="gender">Male</label> <input type="radio"
								name="gender" value="male"
								<%if (user.getGender().equalsIgnoreCase("male")) {%> checked
								<%}%>> <label for="gender">Female</label> <input
								type="radio" name="gender" value="female"
								<%if (user.getGender().equalsIgnoreCase("female")) {%> checked
								<%}%>>
						</div>
					</div>

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="stateid">State :</label>
						</div>
						<div class="text-center w-1/2">
							<select name="stateid" id="stateid"
								class="w-full text-cyan-400 text-center">
								<option value="0">Select State</option>
								<%
								for (State state : statelist) {
								%>
								<option value="<%=state.getId()%>"
									<%if (user.getStateid() == state.getId()) {%> selected <%}%>>
									<%=state.getName()%>
								</option>
								<%
								}
								%>
							</select>
						</div>
					</div>

					<div class="flex flex-row w-full">
						<div class="text-center w-1/2">
							<label for="cityid">Cityid:</label>
						</div>

						<div class="text-center w-1/2">
							<select name="cityid" id="cityid"
								class="w-full text-cyan-400 text-center">
								<option value="0">Select City</option>
								<%
								for (City city : citylist) {
								%>
								<option value="<%=city.getId()%>"
									<%if (user.getCityid() == city.getId()) {%> selected <%}%>>
									<%=city.getName()%>
								</option>
								<%
								}
								%>
							</select>
						</div>
					</div>

					<div class="flex flex-row w-full pb-4">
						<div class="text-center w-1/2">
							<label for="dob">Date of Birth:</label>
						</div>
						<div class="w-1/2 text-cyan-400">
							<input type="date" name="dob"
								class="w-full text-cyan-400 text-center"
								value="<%=user.getDob()%>" required>
						</div>
					</div>

					<div
						class="flex flex-row items-center justify-center border-2 rounded-lg p-3">
						<input type="submit" value="Update User"
							class="text-2xl font-bold">
					</div>
				</div>
			</form>
		</div>

	</div>
</body>
</html>