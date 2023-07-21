package cn.kdan.compdfkit.client;

import cn.kdan.compdfkit.constant.ComPDFKitConstant;
import cn.kdan.compdfkit.enums.CPDFToOfficeEnum;
import cn.kdan.compdfkit.param.*;
import cn.kdan.compdfkit.pojo.comPdfKit.CCreateTaskResult;
import cn.kdan.compdfkit.pojo.comPdfKit.CFileInfo;
import cn.kdan.compdfkit.pojo.comPdfKit.CTaskInfoResult;
import cn.kdan.compdfkit.pojo.comPdfKit.CUploadFileResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;


public class ComPdfKitClientTest {

    private static final String publicKit = "";
    private static final String secretKey = "";
    private static final ComPDFKitClient comPDFKitClient = new ComPDFKitClient(publicKit,secretKey);

    public static void main(String[] args) throws FileNotFoundException {
        ComPdfKitClientTest comPdfKitClientTest = new ComPdfKitClientTest();
        comPdfKitClientTest.pdfToWord();
    }

    public void pdfToWord() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_WORD);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testDOC.pdf");
        String filePassword = "";
        CPDFToWordParameter fileParameter = new CPDFToWordParameter();
        fileParameter.setIsContainImg(CPDFToWordParameter.IS_CONTAIN_IMG);
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToPptx() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testPptx.pdf");
        String filePassword = "";
        CPDFToPptParameter fileParameter = new CPDFToPptParameter();
        fileParameter.setIsContainImg(CPDFToWordParameter.IS_CONTAIN_IMG);
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToExcel() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testExcel.pdf");
        String filePassword = "";
        CPDFToExcelParameter fileParameter = new CPDFToExcelParameter();
        fileParameter.setIsContainImg(CPDFToWordParameter.IS_CONTAIN_IMG);
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToCsv() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testCsv.pdf");
        String filePassword = "";
        CPDFToCsvParameter fileParameter = new CPDFToCsvParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToHtml() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testHtml.pdf");
        String filePassword = "";
        CPDFToHtmlParameter fileParameter = new CPDFToHtmlParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToJpg() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testJpg.pdf");
        String filePassword = "";
        CPDFToJpgParameter fileParameter = new CPDFToJpgParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToRtf() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testRtf.pdf");
        String filePassword = "";
        CPDFToRtfParameter fileParameter = new CPDFToRtfParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfToTxt() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testTxt.pdf");
        String filePassword = "";
        CPDFToTxtParameter fileParameter = new CPDFToTxtParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void addWatermar() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("testAddWatermar.pdf");
        String filePassword = "";
        CAddWatermarkParameter fileParameter = new CAddWatermarkParameter();
        fileParameter.setType("text");
        fileParameter.setScale("1");
        fileParameter.setOpacity("0.5");
        fileParameter.setRotation("0.785");
        fileParameter.setTargetPages("1-2");
        fileParameter.setVertalign("center");
        fileParameter.setHorizalign("left");
        fileParameter.setXoffset("100");
        fileParameter.setYoffset("100");
        fileParameter.setContent("test");
        fileParameter.setTextColor("#59c5bb");
        fileParameter.setFullScreen("111");
        fileParameter.setHorizontalSpace("10");
        fileParameter.setVerticalSpace("10");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void csvToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.csv");
        String filePassword = "";
        CPDFToTxtParameter fileParameter = new CPDFToTxtParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void excelToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.xlsx");
        String filePassword = "";
        CExcelToPDFParameter fileParameter = new CExcelToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void formRecognizerParameter() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CFormRecognizerParameter fileParameter = new CFormRecognizerParameter();
        fileParameter.setLang("auto");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void htmlToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.html");
        String filePassword = "";
        CHtmlToPDFParameter fileParameter = new CHtmlToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void imageSharpeningEnhancement() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CImageSharpeningEnhancementParameter fileParameter = new CImageSharpeningEnhancementParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void layoutAnalysis() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CLayoutAnalysisParameter fileParameter = new CLayoutAnalysisParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void ocr() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        COcrParameter fileParameter = new COcrParameter();
        fileParameter.setLang("auto");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageDelete() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageDeleteParameter fileParameter = new CPageDeleteParameter();
        fileParameter.setPageOptions(Arrays.asList("1","2"));
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageExtract() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageExtractParameter fileParameter = new CPageExtractParameter();
        fileParameter.setPageOptions(Arrays.asList("1","2"));
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageInsert() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageInsertParameter fileParameter = new CPageInsertParameter();
        fileParameter.setTargetPage("1");
        fileParameter.setWidth("500");
        fileParameter.setHeight("800");
        fileParameter.setNumber("2");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageMerge() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageMergeParameter fileParameter = new CPageMergeParameter();
        fileParameter.setPageOptions(Arrays.asList("1","2"));
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageRotation() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageRotationParameter fileParameter = new CPageRotationParameter();
        fileParameter.setPageOptions(Arrays.asList("1","2"));
        fileParameter.setRotation("90");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pageSplit() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPageSplitParameter fileParameter = new CPageSplitParameter();
        fileParameter.setPageOptions(Arrays.asList("1","2"));
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pdfCompress() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CPDFCompressParameter fileParameter = new CPDFCompressParameter();
        fileParameter.setQuality("50");
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pngToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.png");
        String filePassword = "";
        CPngToPDFParameter fileParameter = new CPngToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void pptToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pptx");
        String filePassword = "";
        CPptToPDFParameter fileParameter = new CPptToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void rtfToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.rtf");
        String filePassword = "";
        CRtfToPDFParameter fileParameter = new CRtfToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void stampInspection() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CStampInspectionParameter fileParameter = new CStampInspectionParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void trimCorrection() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CTrimCorrectionParameter fileParameter = new CTrimCorrectionParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void txtToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CTxtToPDFParameter fileParameter = new CTxtToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

    public void wordToPDF() throws FileNotFoundException {
        // create Task
        CCreateTaskResult CCreateTaskResult = comPDFKitClient.createTask(CPDFToOfficeEnum.PDF_TO_PPT);
        // taskId
        String taskId = CCreateTaskResult.getTaskId();
        // upload File
        File file = new File("test.pdf");
        String filePassword = "";
        CWordToPDFParameter fileParameter = new CWordToPDFParameter();
        CUploadFileResult CUploadFileResult = comPDFKitClient.uploadFile(new FileInputStream(file),taskId,filePassword,fileParameter,file.getName());
        String fileKey = CUploadFileResult.getFileKey();
        // perform tasks
        comPDFKitClient.executeTask(taskId);
        // create a ScheduledExecutorService with a fixed thread pool
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        // create an AtomicReference to hold the future
        AtomicReference<ScheduledFuture<?>> futureRef = new AtomicReference<>();
        // schedule a task to check the task status at a fixed rate
        futureRef.set(executor.scheduleAtFixedRate(() -> {
            // get task processing information
            CTaskInfoResult taskInfo = comPDFKitClient.getTaskInfo(taskId);
            // determine whether the task status is "TaskFinish"
            if (taskInfo.getTaskStatus().equals(ComPDFKitConstant.TASK_FINISH)) {
                System.out.println(taskInfo);
                // get the final file processing information
                CFileInfo fileInfo = comPDFKitClient.getFileInfo(fileKey);
                System.out.println(fileInfo);
                // if the task is finished, cancel the scheduled task
                futureRef.get().cancel(false);
            }
        }, 0, 5, TimeUnit.SECONDS));
        // schedule a task to cancel the scheduled task after 15 minutes
        executor.schedule(() -> {
            futureRef.get().cancel(false);
        }, 15, TimeUnit.MINUTES);
        // shutdown the executor
        executor.shutdown();
    }

}