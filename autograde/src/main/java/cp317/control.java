package cp317;

import java.io.IOException;

public class control {
    public static void controlPanel(String assignmentName, String[] tasks, double[] weights) {
        String zipFilePath = JavaPage.forFile1;// equals javaPage.file1
        String rootDir = JavaPage.forFile3;// equals javaPage.file3
        String teacherDirectory = JavaPage.forFile2;
        String[] directories = new String[256];

        int numStudents = 0;
        try {
            numStudents = unzip.runUnzip(zipFilePath, rootDir, directories);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        Student[] students = new Student[numStudents];

        manageDirectories(students, zipFilePath, rootDir, directories);

        Student teacher = createTeacher(teacherDirectory, rootDir);

        AutoScore.runProcesses(teacher, students, numStudents, tasks, weights);

        AutoScore.createCsv(students, assignmentName, numStudents);

    }

    private static Student createTeacher(String directory, String destDir) {
        Student teacher = new Student();

        destDir = destDir + "\\" + "teacher";

        try {
            unzip.runUnzip(directory, destDir, teacher.getDirectory());
            int i = 0, j = 0;
            while (teacher.getDirectoryID(i) != null) {
                if (teacher.getDirectoryID(i).endsWith("java")) {
                    teacher.setTaskID(i, j);
                    j++;
                }
                if (teacher.getDirectoryID(i).endsWith("testing.txt")) {
                    teacher.setTesting(teacher.getDirectoryID(i));
                }
                i++;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return teacher;
    }

    private static void manageDirectories(Student[] students, String zipFilePath, String rootDir,
            String[] directories) {
        int count = 0;
        String destDir;
        while (directories[count] != null) {
            zipFilePath = directories[count];
            students[count] = new Student();
            destDir = rootDir + "\\" + count;
            try {
                unzip.runUnzip(zipFilePath, destDir, students[count].getDirectory());
                int i = 0, j = 0;
                while (students[count].getDirectoryID(i) != null) {
                    if (students[count].getDirectoryID(i).endsWith("java")) {
                        students[count].setTaskID(i, j);
                        j++;
                    }
                    if (students[count].getDirectoryID(i).endsWith("testing.txt")) {
                        students[count].setTesting(students[count].getDirectoryID(i));
                    }
                    i++;
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            count++;

        }
    }
}