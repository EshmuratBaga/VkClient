package project.baga.vk.com.vkclient.common.manager;


import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import project.baga.vk.com.vkclient.ui.BaseActivity;
import project.baga.vk.com.vkclient.ui.BaseFragment;

/**
 * Created by Bagdat Eshmuratov on 17.08.2017.
 * email: eshmuratovbagdat@gmail.com.
 */

public class MyFragmentManager {
    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private Stack<BaseFragment> fragmentStack = new Stack<>();
    private BaseFragment currentFragment;

    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction fragmentTransaction = createAddTransaction(activity, fragment, false);
            fragmentTransaction.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, fragmentTransaction, false);
        }
    }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction fragmentTransaction = createAddTransaction(activity, fragment, true);
            fragmentTransaction.add(containerId, fragment);
            commitAddTransaction(activity, fragment, fragmentTransaction, true);
        }
    }


    public boolean removeCurrentFragment(BaseActivity activity) {
        return removeFragment(activity, currentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = fragment != null && fragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if (canRemove) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            fragmentStack.pop();
            currentFragment = fragmentStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }
        return canRemove;
    }


    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        if (addToBackStack)
            fragmentTransaction.addToBackStack(fragment.getTag());

        return fragmentTransaction;
    }

    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction,
                                      boolean addToBackStack) {
        if (transaction != null) {
            currentFragment = fragment;

            if (!addToBackStack) {
                fragmentStack = new Stack<>();
            }

            fragmentStack.add(fragment);

            commitTransaction(activity, transaction);

        }
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction) {
        transaction.commit();

        activity.fragmentOnScreen(currentFragment);
    }

    public boolean isAlreadyContains(BaseFragment fragment) {
        if (fragment == null) return false;

        return currentFragment != null && currentFragment.getClass().getName().equals(fragment.getClass().getName());
    }


    public Stack<BaseFragment> getFragmentStack() {
        return fragmentStack;
    }
}
