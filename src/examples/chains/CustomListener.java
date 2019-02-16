/*
 * Copyright (C) 2014, United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 *
 * Symbolic Pathfinder (jpf-symbc) is licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package chains;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;
import gov.nasa.jpf.PropertyListenerAdapter;
import gov.nasa.jpf.vm.ChoiceGenerator;
import gov.nasa.jpf.vm.ClassInfo;
import gov.nasa.jpf.vm.Instruction;
import gov.nasa.jpf.vm.LocalVarInfo;
import gov.nasa.jpf.vm.MethodInfo;
import gov.nasa.jpf.vm.StackFrame;
import gov.nasa.jpf.vm.ThreadInfo;
import gov.nasa.jpf.vm.Types;
import gov.nasa.jpf.vm.VM;

import gov.nasa.jpf.jvm.bytecode.ARETURN;
import gov.nasa.jpf.jvm.bytecode.DRETURN;
import gov.nasa.jpf.jvm.bytecode.FRETURN;
import gov.nasa.jpf.jvm.bytecode.IRETURN;
import gov.nasa.jpf.jvm.bytecode.JVMInvokeInstruction;
import gov.nasa.jpf.jvm.bytecode.LRETURN;
import gov.nasa.jpf.jvm.bytecode.JVMReturnInstruction;
import gov.nasa.jpf.report.ConsolePublisher;
import gov.nasa.jpf.report.Publisher;
import gov.nasa.jpf.report.PublisherExtension;
import gov.nasa.jpf.search.Search;
import gov.nasa.jpf.symbc.bytecode.BytecodeUtils;
import gov.nasa.jpf.symbc.bytecode.INVOKESTATIC;
import gov.nasa.jpf.symbc.concolic.PCAnalyzer;

import gov.nasa.jpf.symbc.numeric.Comparator;
import gov.nasa.jpf.symbc.numeric.Expression;
import gov.nasa.jpf.symbc.numeric.IntegerConstant;
import gov.nasa.jpf.symbc.numeric.IntegerExpression;
import gov.nasa.jpf.symbc.numeric.PCChoiceGenerator;
import gov.nasa.jpf.symbc.numeric.PathCondition;
import gov.nasa.jpf.symbc.numeric.RealConstant;
import gov.nasa.jpf.symbc.numeric.RealExpression;
import gov.nasa.jpf.symbc.numeric.SymbolicInteger;
import gov.nasa.jpf.symbc.numeric.SymbolicReal;

import gov.nasa.jpf.symbc.numeric.SymbolicConstraintsGeneral;
//import gov.nasa.jpf.symbc.numeric.SymbolicInteger;

import gov.nasa.jpf.util.Pair;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

public class CustomListener extends PropertyListenerAdapter implements PublisherExtension {

    /*
     * Locals to preserve the value that was held by JPF prior to changing it in order to turn off state matching during
     * symbolic execution no longer necessary because we run spf stateless
     */

    private String currentMethodName = "";

    public CustomListener(Config conf, JPF jpf) {
        jpf.addPublisherExtension(ConsolePublisher.class, this);
    }

    // Writes the method summaries to a file for use in another application
    // private void writeTable(){
    // try {
    // BufferedWriter out = new BufferedWriter(new FileWriter("outFile.txt"));
    // Iterator it = allSummaries.entrySet().iterator();
    // String line = "";
    // while (it.hasNext()){
    // Map.Entry me = (Map.Entry)it.next();
    // String methodName = (String)me.getKey();
    // MethodSummary ms = (MethodSummary)me.getValue();
    // line = "METHOD: " + methodName + "," +
    // ms.getMethodName() + "(" + ms.getArgValues() + ")," +
    // ms.getMethodName() + "(" + ms.getSymValues() + ")";
    // out.write(line);
    // out.newLine();
    // Vector<Pair> pathConditions = ms.getPathConditions();
    // if (pathConditions.size() > 0){
    // Iterator it2 = pathConditions.iterator();
    // while(it2.hasNext()){
    // Pair pcPair = (Pair)it2.next();
    // String pc = (String)pcPair.a;
    // String errorMessage = (String)pcPair.b;
    // line = pc;
    // if (!errorMessage.equalsIgnoreCase(""))
    // line = line + "$" + errorMessage;
    // out.write(line);
    // out.newLine();
    // }
    // }
    // }
    // out.close();
    // } catch (Exception e) {
    // }
    // }

    @Override
    public void propertyViolated(Search search) {
    }

    @Override
    public void instructionExecuted(VM vm, ThreadInfo currentThread, Instruction nextInstruction,
            Instruction executedInstruction) {

    	System.out.println("EXEC");
    }

    /*
     * The way this method works is specific to the format of the methodSummary data structure
     */

    // -------- the publisher interface
    @Override
    public void publishFinished(Publisher publisher) {
    }

}
