<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<!--    List Surveys screen    -->
<div class="container">
	<div class="welcomeBox">
		<h2 class="title">Polls @ Xoriant</h2>
	</div>

	<div class="surveyListBox row-fluid">
		<div class="span3" ng-repeat="survey in surveys | orderBy:'surveyId'">
			<h2>Survey {{ $index+1 }}</h2>
			<p class="question">{{ survey.title}}?</p>
			<ul>
				<li>{{ survey.choice1 }}</li>
				<li>{{ survey.choice2 }}</li>
			</ul>






			<p>
				<a class="btn btn-primary"
					ui-sref="responseInfo({id:survey.surveyId})">View responses Â»</a><br>
				<br> <a class="btn btn-primary"
					ui-sref="idInfo({id:survey.surveyId})">View Survey Info Â»</a>
			</p>

		</div>

		<!--               <div class="pagination"> -->
		<!--           <ul> -->
		<!--             <li ng-class="prevPageDisabled()"> -->
		<!--               <a href ng-click="prevPage()">« Prev</a> -->
		<!--             </li> -->
		<!--             <li ng-repeat="n in range()" -->
		<!--               ng-class="{active: n == currentPage}" ng-click="setPage(n)"> -->
		<!--               <a href="#">{{n+1}}</a> -->
		<!--             </li> -->
		<!--             <li ng-class="nextPageDisabled()"> -->
		<!--               <a href ng-click="nextPage()">Next »</a> -->
		<!--             </li> -->
		<!--           </ul> -->
		<!--         </div> -->
		<!--           </div> -->








	</div>