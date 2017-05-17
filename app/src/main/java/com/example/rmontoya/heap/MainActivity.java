package com.example.rmontoya.heap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> integers = Arrays.asList(4,3,9,7,6,1,8,2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeMaxHeapify(integers.size()/2);

        Log.d(MainActivity.class.getName(), "" + integers.toString());
    }

    private void makeMaxHeapify(int pivotPosition) {
        compareLeftChild(pivotPosition);
        compareRightChild(pivotPosition);
        if(pivotPosition - 1 > 0) makeMaxHeapify(pivotPosition - 1);
    }

    private void compareLeftChild(int parentPosition) {
        int leftPosition = parentPosition * 2;
        if(leftPosition > integers.size()) return;
        int parent = integers.get(parentPosition - 1);
        int leftChild = integers.get(leftPosition -1);

        if (parent < leftChild) {
            integers.set(parentPosition -1, leftChild);
            integers.set(leftPosition -1, parent);
        }
    }

    private void compareRightChild(int parentPosition) {
        int rightPosition = (parentPosition * 2) + 1;
        if(rightPosition > integers.size()) return;
        int parent = integers.get(parentPosition - 1);
        int rightChild = integers.get(rightPosition -1);

        if (parent < rightChild) {
            integers.set(parentPosition - 1, rightChild);
            integers.set(rightPosition - 1, parent);
        }
    }

}