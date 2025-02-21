// Task 1: Build a Student Management System
// Create a Student class with name, id, and courses. Add methods to enroll/drop courses.

// Use encapsulation to protect GPA calculation logic.

// 1.upload a screen record video of the project(if you record the screen when you write the code, it will be added more value in your evaluation)
// 2.provide the source code

//Creating a Stufent class

class Student {

  //Attribute
  String name;
  String id;
  Map<String, String> _courses = {};

  //Constructor
  Student(this.name, this.id);

  //Method to enroll in a course
  void enrollcourse(String coursename) {
    if (!_courses.containsKey(coursename)) {
      _courses[coursename] = 'N/A';
    
  //Grade is N/A until assigned

      print('Enrolled in $coursename');
    } else {
      print('Already enrolled in $coursename');
    }
  }

  //Method for droping a course

  void dropcourse(String coursename) {
    if (_courses.containsKey(coursename)) {
      _courses.remove(coursename);
      print('Dropped $coursename');
    } else {
      print('Not enrolled in $coursename');
    }
  }

  //Method to set grade for a course
  void setgrade(String coursename, String grade) {
    if (_courses.containsKey(coursename)) {
      _courses[coursename] = grade;
      print('Grade for $coursename set to $grade');
    } else {
      print('Not enrolled in $coursename');
    }
  }

  //public method to get gpa

  double getGpa() {
    return _calculateGpa();
  }

  //protected method to calculate gpa
  double _calculateGpa() {
    if (_courses.isEmpty) {
      return 0;
    }
    double totalPoints = 0;
    int totalCourses = 0;
    Map<String, double> gradepoints = {
      'A+': 4,
      'A': 3.75,
      'A-': 3.5,
      'B': 3.0,
      'D': 2.0,
      'F': 0.0
    };

    _courses.forEach((course, grade) {
      if (gradepoints.containsKey(grade)) {
        totalPoints += gradepoints[grade]!;
        totalCourses++;
      }
    });

    return totalCourses > 0 ? totalPoints / totalCourses : 0.0;
  }

  //merthod to display student info

  void displayinfo() {
    print('Student Name : $name');
    print('Student ID : $id');
    print('Enrolled Courses and Grades :');
    _courses.forEach((course, grade) {
      print('-$course:$grade');
    });
  }
}

void main() {
  //creating a Student object
  Student student = Student('animesh', '5359');

  //enrolling  in courses

  student.enrollcourse('Math');
  student.enrollcourse('coumputer funda');
  student.enrollcourse('ML');

  //student grades
  student.setgrade('Math', 'A+');
  student.setgrade('ML', 'A');
  student.setgrade('computer funda', 'A-');
  //displaying student info
  student.displayinfo();
  print('Gpa :${student.getGpa()}');

  //Dropping a course  and recalculating GPA
  student.dropcourse('Math');
  student.displayinfo();
  print('GPA after dropping Math : ${student.getGpa()}');
}
