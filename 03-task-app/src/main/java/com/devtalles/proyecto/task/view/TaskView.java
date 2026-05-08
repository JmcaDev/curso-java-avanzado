package com.devtalles.proyecto.task.view;

import com.devtalles.proyecto.task.controller.TaskController;
import com.devtalles.proyecto.task.exceptions.TaskException;
import com.devtalles.proyecto.task.exceptions.TaskValidationException;
import com.devtalles.proyecto.task.model.Task;

import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        while(true){
            System.out.println("\n Gestion de Tareas");
            System.out.println("1. Agregar Tarea");
            System.out.println("2. Eliminar Tarea");
            System.out.println("3. Actualizar Tarea");
            System.out.println("4. Actualizar estado de la tarea");
            System.out.println("5. Mostrar Tareas");
            System.out.println("6. Mostrar Tareas Pendientes");
            System.out.println("7. Mostrar Tareas Completadas");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion: ");

            String option = scanner.nextLine();
            switch (option){
                case "0":
                    System.out.println("Saliendo del sistema");
                    return;
                case "1":
                    addTaskView();
                    break;
                case "2":
                    removeTaskView();
                    break;
                case "3":
                    updateTaskView();
                    break;
                case "4":
                    updateTaskCompletedView();
                    break;
                case "5":
                    showTasksView();
                    break;
                case "6":
                    showPendingTasksView();
                    break;
                case "7":
                    showCompletedTasksView();
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }
        }
    }

    public void addTaskView(){
        try {
            Task task = getTaskInput();
            taskController.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());

            System.out.println("Tarea agregada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void removeTaskView(){
        try{
            System.out.println("Ingrese el ID a eliminar: ");
            String id = scanner.nextLine();
            this.taskController.removeTask(id);
            System.out.println("Tarea eliminada correctamente");
        }catch(TaskValidationException | TaskException e){
            System.out.println("Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void showTasksView(){
        try{
            System.out.println("\nLista de Tareas:");
            this.taskController.showTasks();
        }catch(TaskValidationException | TaskException e){
            System.out.println("Error: " + e.getMessage());
        }catch (Exception e){
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void updateTaskView(){
        try {
            Task task = getTaskInput();
            taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());

            System.out.println("Tarea actualizda correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void updateTaskCompletedView(){
        Boolean completed=null;
        try {
            String id = validateValue("Ingrese el ID a de la tarea: ", "El ID no puede estar vacio");

            while (completed==null){
                System.out.println("¿Esta completada? true/false");
                String input = scanner.nextLine().trim().toLowerCase();
                if(input.equals("true")){
                    completed = true;
                }else if(input.equals("false")){
                    completed = false;
                }else{
                    System.out.println("El valor ingresado no es valido, ingrese: true o false");
                }
            }
            taskController.updateTaskCompleted(id, completed);
            System.out.println("Estado de la tarea actualizada correctamente");
        } catch (TaskValidationException | TaskException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void showCompletedTasksView(){
        try{
            System.out.println("\nTareas Completada");
            taskController.showCompletedTasks();
        }catch (TaskValidationException | TaskException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    public void showPendingTasksView(){
        try{
            System.out.println("\nTareas Pendientes");
            taskController.showPendingTasks();
        }catch (TaskValidationException | TaskException e){
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error inesperado, Contacte con el soporte");
            e.printStackTrace();
        }
    }

    private Task getTaskInput(){
        String id;
        String title;
        String description;
        Boolean completed = null;

        id = validateValue("Ingrese el ID de la tarea", "El ID no puede estar vacio");
        title = validateValue("Ingrese el titulo de la tarea", "El titulo no puede estar vacio");
        description = validateValue("Ingrese la descripcion de la tarea", "La descripcion no puede estar vacia");

        while (completed==null){
            System.out.println("¿Esta completada? true/false");
            String input = scanner.nextLine().trim().toLowerCase();
            if(input.equals("true")){
                completed = true;
            }else if(input.equals("false")){
                completed = false;
            }else{
                System.out.println("El valor ingresado no es valido, ingrese: true o false");
            }
        }

        return new Task(id, title, description, completed);
    }

    private String validateValue(String message, String errorMessage){
        String value;
        do{
            System.out.println(message);
            value = scanner.nextLine();
            if(value.isEmpty()){
                System.out.println(errorMessage);
            }
        }while(value.isEmpty());
        return value;
    }
}
