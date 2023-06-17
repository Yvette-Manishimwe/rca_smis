<style>
	.nav-i-wrapper-hide {
		opacity: 0;
	}
	.nav-i-wrapper:hover > .nav-i-wrapper-hide {
		opacity: 1;
	}
</style>

<div style="width: 100%; height: fit-content; padding: 10px 0px; display: flex; align-items: center; justify-content: center; gap: 2rem">
	<div style="position: relative " class="nav-i-wrapper">
		<a class="idTabs" href="#admin" style="display: flex; text-decoration: none; color: white; font-size: 1rem">
			<img src="icons/application_side_expand.png" />
			Admin
		</a>
		<div class="nav-i-wrapper-hide" style="position:absolute; top: 2rem; background: #006889ab; padding: .5rem; gap: .2rem; box-shadow: 0.1rem 1rem 1rem 0.1rem #ffffff63; transition: all 1s ease; display: flex; flex-direction: column; gap: .2rem">
			<a href="createuser.php?page=createuser" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
				<img src="icons/user_add.png" style="width: 1rem; height: 1rem"/>
				Create User
			</a>
			<a href="listuser.php?page=users&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
				<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
				List of users
			</a>
		</div>
	</div>

	<div style="height: fit-content; display: flex; align-items: center; justify-content: center; gap: 1rem">
		<a href="listemployees.php?page=employees&&user_role=adm&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem">
			<img src="icons/application_view_columns.png" />
			Employees
		</a>

		<div style="position: relative " class="nav-i-wrapper">
			<a class="idTabs" href="#students" style="display: flex; text-decoration: none; color: white; font-size: 1rem">
				<img src="icons/application_side_expand.png" />
				Students
			</a>
			<div class="nav-i-wrapper-hide" style="position:absolute; top: 2rem; background: #006889ab; padding: .5rem; gap: .2rem; box-shadow: 0.1rem 1rem 1rem 0.1rem #ffffff63; transition: all 1s ease; display: flex; flex-direction: column; gap: .2rem">
				<a href="liststudents.php?page=students&&user_role=adm&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Students
				</a>
				<a href="listparents.php?page=parents&&user_role=adm&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Parents
				</a>
			</div>
		</div>

		<div style="position: relative " class="nav-i-wrapper">
			<a class="idTabs" href="#marks" style="display: flex; text-decoration: none; color: white; font-size: 1rem">
				<img src="icons/application_side_expand.png" />
				Marks
			</a>

			<div class="nav-i-wrapper-hide" style="position:absolute; top: 2rem; background: #006889ab; padding: .5rem; gap: .2rem; box-shadow: 0.1rem 1rem 1rem 0.1rem #ffffff63; transition: all 1s ease; display: flex; flex-direction: column; gap: .2rem">
				<a href="listmarks.php?page=marks&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Marks
				</a>
				<a href="listcourse.php?page=courses&&action=list" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Courses
				</a>
			</div>
		</div>
		<div style="position: relative " class="nav-i-wrapper">
			<a class="idTabs" href="#reports" style="display: flex; text-decoration: none; color: white; font-size: 1rem">
				<img src="icons/application_side_expand.png" />
				Reports
			</a>

			<div class="nav-i-wrapper-hide" style="position:absolute; top: 2rem; background: #006889ab; padding: .5rem; gap: .2rem; box-shadow: 0.1rem 1rem 1rem 0.1rem #ffffff63; transition: all 1s ease; display: flex; flex-direction: column; gap: .2rem">
				<a href="studentreporttxt.php?page=studenttxt" style="display: flex; text-decoration: none; color: white; font-size: 1rem; padding-left: .5rem;">
					<img src="icons/application_view_list.png" />
					Students reports
				</a>
				<a href="coursereportxt.php?page=coursetxt" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Courses reports
				</a>
				<a href="marksreporttxt.php?page=markstxt" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/application_view_list.png" style="width: 1rem; height: 1rem"/>
					Marks Report
				</a>
				<a href="instructorspdf.php?" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/page_white_acrobat.png" style="width: 1rem; height: 1rem"/>
					All Instructors PDF
				</a>
				<a href="studentreportpdf.php?page=studenttxt" style="display: flex; text-decoration: none; color: white; font-size: 1rem; margin-left: .5rem; white-space: nowrap ">
					<img src="icons/page_white_acrobat.png" style="width: 1rem; height: 1rem"/>
					All Students PDF
				</a>
			</div>
		</div>
	</div>
</div>
